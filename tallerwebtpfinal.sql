

create database if not exists tallerwebtpfinal;
use tallerwebtpfinal;


INSERT INTO imagenfondo(nombreimgfondo)
VALUES("Entrada.jpg");


INSERT INTO pregunta(id, textoDeLaPregunta,imagenfondo_id)
VALUES(1,"Luego de terminar la secundaria, decidi ingresar a la Universidad. Aprobe el curso de ingreso en el primer intento.
Despues de unas pequeñas vacaciones, ha llegado el primer dia de mi carrera universitaria.
Decidi elegir Desarrollo web, ya que siempre me ha gustado la informatica.
La primera materia es matematicas, en el aula 232. Segun el mapa de la pagina web, puedo llegar hasta alla desde el departamento de Humanidades o el de Ingenieria.
¿Por cual deberia ir?",1),
(2,"¡Primer dia de clases y ya estoy llegando tarde!
Bueno, este debe ser el aula. Me peino un poco y entro.<br><br> 
- Jugador: Buenos dias profesor.<br>
- Profesor: Buenas noches, en el fondo hay una silla desocupada.<br>
- Profesor: Bien...El segundo calculo para resolver este ejercicio es...<br>
No entiendo que esta explicando. <br>¿Deberia preguntarle a mi compañero?",1),
(3,"Se lo ve muy concentrado, mejor no le hablo. <br>
-Compañero: Disculpame, mi nombre es Pablo, ¿entendiste lo que el profesor explicaba sobre el rectangulo? <br>
Lo miro y respondo.<br>
-Jugador: Hola, yo tampoco entendi. Por cierto, me llamo /nombre/.<br>
Terminamos los dos riendonos.",1),
(4,"LLego puntual",1),

(400,"Has perdido por Estres",1),
(500,"Has abandonado por Rendimiento",1),
(600,"Has desaprobado pero eres popular",1);



INSERT INTO respuesta(id, rendimiento, social, estres, dinero, opcion,gasto, pregunta_id, preguntaSiguiente_id)
VALUES(100,30,30,30,200,"Jugar",0,null,1),
(101,25,30,10,200,"Humanidades",0,1,2),
(102,35,-10,20,200,"Ingenieria",200,1,4),
(103,-5,12,100,200,"No preguntarle",0,2,3),
(104,0,0,0,0,"Inicio",0,400,null),
(105,0,0,0,0,"Inicio",0,500,null),
(106,0,0,0,0,"Inicio",0,600,null);


INSERT INTO imagenpersonaje(nombre)
VALUES("Daiana%20(1).png"),
("Nicolas%20(1).png"),
("Pablo%20(1).png");

							
Insert into tablapreguntapersonaje(idpregunta, idimagenpersonaje)
value (1,1),
(2,1),
(3,1),
(3,2),
(4,1);


INSERT INTO imagenfondo_pregunta(imagenfondo_id,pregunta_id)
VALUES(1,1),
(1,2),
(1,3),
(1,4);


SELECT * FROM RESPUESTA;
SELECT * FROM PREGUNTA;
SELECT * FROM jugador;
SELECT * FROM Estadistica; 
select * from imagenfondo; 
select * from imagenpersonaje; 
select * from tablajugadorrespuesta;
select * from tablapreguntapersonaje;
select * from imagenfondo_pregunta