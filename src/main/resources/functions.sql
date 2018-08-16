CREATE OR REPLACE FUNCTION public.fn_hotarea()
  RETURNS trigger AS
$BODY$
DECLARE
	rec RECORD;
        _count_motorista INTEGER;
        _count_passageiro INTEGER;
BEGIN	

        _count_passageiro   := (SELECT COUNT(*) FROM passageiro WHERE online = TRUE AND bairro = NEW.bairro AND cidade = NEW.cidade AND uf = NEW.uf);
        _count_motorista    := (SELECT COUNT(*) FROM veiculo WHERE online = TRUE AND bairro = NEW.bairro AND cidade = NEW.cidade AND uf = NEW.uf);

        SELECT * FROM hotarea WHERE bairro = NEW.bairro AND cidade = NEW.cidade AND uf = NEW.uf INTO rec;
        IF rec IS NULL THEN
            INSERT INTO hotarea (bairro, cidade, latitude, longitude, motoristas, passageiros, uf) 
            VALUES (NEW.bairro, NEW.cidade, NEW.latitude, NEW.longitude, _count_motorista, _count_passageiro, NEW.uf);
        ELSE
            UPDATE hotarea SET 
                latitude = NEW.latitude,
                longitude = NEW.longitude,
                motoristas = _count_motorista,
                passageiros = _count_passageiro
            WHERE 
                bairro = NEW.bairro AND cidade = NEW.cidade AND uf = NEW.uf;
        END IF;

        RETURN NEW;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
  

CREATE TRIGGER tg_veiculo_hotarea
    AFTER INSERT OR DELETE OR UPDATE 
    ON public.veiculo
    FOR EACH ROW
    EXECUTE PROCEDURE public.fn_hotarea();

CREATE TRIGGER tg_passageiro_hotarea
    AFTER INSERT OR DELETE OR UPDATE 
    ON public.passageiro
    FOR EACH ROW
    EXECUTE PROCEDURE public.fn_hotarea();





CREATE OR REPLACE FUNCTION public.haversine(
	orglat double precision,
	orglng double precision,
	destlat double precision,
	destlng double precision)
    RETURNS double precision
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$

DECLARE
BEGIN

	return (
		6378140 * acos(cos(radians(orglat)) * cos(radians(destlat) ) * 
		cos(radians(destlng) - radians(orglng)) + sin(radians(orglat)) * sin(radians(destlat)))
	);

END;

$BODY$;