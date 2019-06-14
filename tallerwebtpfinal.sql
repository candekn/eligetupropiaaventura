/*Ejecutar en Mysql
 
 Antes, hay que modificar el tamaño del varchar(650) del texto de la ruta
 en el Mysql, si no no va a guardar los textos largos
 
use tallerwebtpfinal;
insert into ruta(opcion1, opcion2,opcion3, texto)
values("Humanidades","Ingenieria","no","Luego de terminar la secundaria, decidí ingresar a la Universidad. Aprobé el curso de ingreso en el primer intento.
Después de unas pequeñas vacaciones, ha llegado el primer día de mi carrera universitaria.
Decidí elegir Desarrollo web, ya que siempre me ha gustado la informática.
La primera materia es matemáticas, en el aula 232. Según el mapa de la página web, puedo llegar hasta allí desde el departamento de Humanidades o el de Ingeniería.
¿Por cuál debería ir?");



insert into ruta(opcion1, opcion2,opcion3, texto)
values ("No preguntar","Preguntarle","no","¡Primer día de clases y ya estoy llegando tarde!

Bueno, este debe ser el aula. Me peino un poco y entro.

- Jugador: Buenos días profesor.

- Profesor: Buenas noches, en el fondo hay una silla desocupada.

- Profesor: “...El segundo cálculo para resolver este ejercicio es...”

No entiendo qué está explicando. ¿Debería preguntarle a mi compañero?");


insert into ruta(opcion1, opcion2,opcion3, texto)
values ("no","no","Siguiente","Se lo ve muy concentrado, mejor no le hablo.

-Compañero: Disculpame, mi nombre es Pablo, ¿entendiste lo que el profesor explicaba sobre el rectángulo?”

Lo miro y respondo.

-Jugador: Hola, yo tampoco entendí. Por cierto, me llamo /nombre/.

Terminamos los dos riéndonos.
");

insert into ruta(opcion1, opcion2,opcion3, texto)
values ("no","no","Siguiente"," Nuestro compañero, llamado Pablo,  nos contó que el profesor hablaba acerca de una fórmula del rectángulo, pero no entendió cómo era.");

insert into ruta(opcion1, opcion2,opcion3, texto)
values ("no","no","Siguiente","¡Bien! Era un camino mucho más directo por el departamento de Ingenieria.

Gracias a esto estoy llegando puntual a la clase, aunque hay personas afuera del aula aún. No es día para socializar, entraré al aula y conoceré esta materia, luego haré amistades.

El profesor se presenta, y comienza la clase.

Profesor: Bien, recuerden que el area de un rectángulo se resuelve con dos cálculos distintos..

Lo bueno de haber llegado a horario es que pude seguir el ritmo de la clase. Intentaré recordar los cálculos");

insert into ruta(opcion1, opcion2,opcion3, texto)
values ("Quedarse","Salir","","Receso
La clase transcurrió con normalidad.

Profesor: Bueno chicos, es hora de tomarnos un break. Pueden salir afuera o quedarse en el aula.

No tengo dinero para comprarme nada, ¿qué hago? ¿Salgo igual a tomar aire o me quedo en el aula repasando lo aprendido?");


insert into ruta(opcion1, opcion2,opcion3, texto)
values ("no","no","Siguiente","Me he pasado todo el recreo repasando. Comienza a dolerme un poco la cabeza…");



insert into ruta(opcion1, opcion2,opcion3, texto)
values ("Me doy vuelta para ver quien es","Lo ignoro y sigo caminando","","¡Hay demasiada gente! Es impresionante… ¿Eh? Oigo a alguien llamándome…");

insert into ruta(opcion1, opcion2,opcion3, texto)
values ("no","no","Siguiente","Darse la vuelta: ¡Oh por Dios! ¡Son mis antiguos compañeros del curso de ingreso!

Paso todo el receso hablando con ellos. Al parecer coincidimos en dos materias...");

insert into ruta(opcion1, opcion2,opcion3, texto)
values ("no","no","Siguiente","Seguro que estaban llamando a otra persona con el mismo nombre que yo. Mejor voy a sentarme.Paso todo el receso escuchando música.");

insert into ruta(opcion1, opcion2,opcion3, texto)
values ("Trabajar solo","Trabajar en equipo","","Bueno chicos, espero hayan descansado un poco. Para esta segunda parte quiero comprobar su nivel, así que vamos a hacer un pequeño trabajo práctico de nivelación. Pueden hacerlo solos o en grupo de a dos. Ustedes eligen.

¿Qué hago?");



 

Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (10,10,10,10,"Jugar",1);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (4,-3,-2,1,"Humanidades",2);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (-3,0,0,1,"No preguntar",3);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (9,5,0,1,"Preguntarle",4);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (9,5,0,1,"Ingenieria",5);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (9,5,0,1,"Siguiente",6);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (9,5,0,1,"Quedarse",7);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (9,5,0,1,"Salir",8);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (9,5,0,1,"Me doy vuelta para ver quien es",9);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (9,5,0,1,"Lo ignoro y sigo caminando",10);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (9,5,0,1,"Siguiente",11);
