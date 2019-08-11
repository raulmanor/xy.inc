# Descrição

Repositório com um app REST, utilizando o PostgresSQL como banco de dados para armazenar os POI (Points of Interests) do mapa.
Dada uma localização (x,y) é feito o cálculo da distância no plano cartesiado, mostrando como resultados locais com menos de 10m de distância.

Cadastrando um novo Ponto de interesse
-----------------------

Para o cadastro de Pontos de Interesse, em seu client HTTP, colocar o seguinte caminho:

    POST: http://localhost:8080/XY.Inc/webresources/xyInc/Poi/cadastrar/

Segue abaixo um exemplo de JSON do modelo do POI:

    {
	    "ponto" : "Hospital",
	    "cooX" : "30",
	    "cooY" : "32"
    }

Listando todos os Pontos de interesse
-----------------------

Para listar todos os Pontos de interese, uma requisição GET deverá ser feita, conforme descrito abaixo:

    GET: http://localhost:8080/XY.Inc/webresources/xyInc/Poi/getListaPoi
    
-----------------------------

Para descobrir quais são os Pontos de interesse próximos da localização, uma requisição GET deverá ser montada, conforme descrito abaixo

    GET: http://localhost:8080/XY.Inc/webresources/xyInc/Poi/getPontoProximo/20,10


Criação do banco
----------------

Script para criaçao do banco de dados 

CREATE DATABASE "xy.Inc"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;

       CREATE TABLE poi
(
  ponto character varying(50) NOT NULL,
  coox character varying(50) NOT NULL,
  cooy character varying(50) NOT NULL,
  CONSTRAINT poi_ponto_key UNIQUE (ponto)
)

TESTES
-----------------------

Para executar os testes, contruir e fazer o depoy do servidor depois usar a URL:

    http://localhost:8080/XY.Inc/test-resbeans.html


