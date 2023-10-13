#Autor: Cristian Gualtero
 #language: es
@HistoriaDeUsuario
Característica:  Se intenta relizar una regresion de los servicios exitosos de registro, login y compra de un producto




  @casoingreso
  Esquema del escenario: Verificar ingreso correcto
    Dado que cristian gualteros ingresa a la app
    Cuando Cristian ba al modulo de login Y digita sus credenciales
      | user   | pass   |
      | <user> | <pass> |
    Entonces verifica que pudo ingresar correctamente y ve su nombre en el homepage

    Ejemplos:
      | user  | pass     |
      | test01 | Test2023* |































