Informe del trabajo extension-libreria

- Los tests pasaron todos, aunque hay 9 clases, de las cuales solo tres tienen su clase de pruebas (Faltan Tests). Por lo que procedo a agregar las clases de pruebas faltantes, así asegurar de que todo siga andando bien a pesar de las modificaciones que vaya a realizar,y además verificar si estaba andando realmente bien antes.

- Se agregó la anotación @Override al método getPrecio() de la clase ArticuloDeLibreria.

- Tengo que modificar la clase Producto, ya que tiene puesta la periodicidad ahí. Y el enunciado pedía que la Revista y el Periodico tuvieran una periodicidad, no tiene sentido que un Libro o un ArtículoDeLibrería lo tuviera. Entonces saqué periodicidad de Producto (estaba en el constructor y como atributo), se lo agregué como atributo (con getter y setter) a una clase abstracta llamada ProductoSuscribible que hereda de Producto, y a su vez Periodico y Revista heredan de ProductoSuscribible. Esto hizo que además de editar todas las clases que heredaban de Producto haya tenido que modificar la clase Suscripcion.
 También tuve que adaptar los tests a los cambios.

-En la clases de prueba IntegracionTest y SuscripcionTest, las variables no cumplen con la convención, y arrancan con mayúsculas. También ninguno de los atributos es privado. Por lo que procedo a hacer las modificaciones.

- En el codigo no se deja ningún espacio entre cada línea (en ningún lugar, ni para separar los atributos de los métodos en varios casos), lo que le agrega dificultad a la lectura del código. Por lo que le voy a agregar espacios para facilitar su lectura.

- Cuando agregué la clase de prueba para Compra observé que la solución permitía que pueda comprar cantidades negativas de un producto. Entonces modifiqué la clase para que no se pueda hacer eso. Y además si se quiere hacer lanza una excepción llamada CantidadNegativaException.

- Al crearse ProductoTest se vio que se dejaba poner precios negativos. Entonces no permití hacer eso, y si se intenta hacer se lanza una excepción.

- El método calcularMontoACobrar(mes, cliente) está mal escrito. Ya que esta escrito de la siguiente forma en la solución recibida: "CalcularMontoACrobar(String mes, Cliente miCliente)". Como se puede ver no respeta la convención de arrancar el nombre de un método con minúscula, y además en vez de "Crobar" debería decir "Cobrar". Procedo a hacer los arreglos correspondientes.

- Tal como está la implementación recibida, me veo en necesidad de crear la clase AlquilerDeLibro. Esto es debido a que para que la Libreria reconozca una compra, se tiene que agregar una nueva compra agregando en ella los datos necesarios (como el cliente), y un método de Libreria la agrega a una lista. Con Suscripcion pasa exactamente lo mismo. Así que para seguir la línea voy a hacer lo mismo con AlquilerDeLibro.
 Si lo llegase a implementar de diferente manera sería contradictorio con la lógica recibida.

- Para seguir con la tónica, se agrego en Libreria (que ya contenía: una lista de Cliente, una de Compra y una de Suscripcion), la lista de AlquilerDeLibro.

- Como en el caso de las otras listas, la lista de AlquilerDeLibro va a ser recorrida y se van a sacar los datos necesarios para hacer el cálculo de monto a cobrar.


