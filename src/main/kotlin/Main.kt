data class Tienda(val nombre: String, val clientes: List<Clientes>) {

    fun obtenerConjuntoDeClientes(): Set<Clientes> = clientes.toSet()

    fun obtenerCiudadesDeClientes(): Set<Ciudad> = clientes.map { it.ciudad }.toSet()

    fun obtenerClientesPor(ciudad: Ciudad): List<Clientes> = clientes.filter { it.ciudad == ciudad }

    fun checkTodosClientesSonDe(ciudad: Ciudad): Boolean = clientes.all { it.ciudad == ciudad }

    fun hayClientesDe(ciudad: Ciudad): Boolean = clientes.any { it.ciudad == ciudad }

    fun cuentaClientesDe(ciudad: Ciudad): Int = clientes.count { it.ciudad == ciudad }

    fun encuentraClienteDe(ciudad: Ciudad): Clientes? = clientes.find { it.ciudad == ciudad }

    fun obtenerClientesOrdenadosPorPedidos(): List<Clientes> = clientes.sortedByDescending { it.pedidos.size }

    fun obtenerClientesConPedidosSinEngregar(): Set<Clientes> = clientes.filter { it.pedidos.any() { !it.estaEntregado } }.toSet()
}

    data class Clientes(val nombre: String, val ciudad: Ciudad, val pedidos: List<Pedido>) {
        override fun toString() = "$nombre from ${ciudad.nombre}"
    }

    data class Pedido(val productos: List<Producto>, val estaEntregado: Boolean)

    data class Producto(val nombre: String, val precio: Double) {
        override fun toString() = "'$nombre' for $precio"
    }

    data class Ciudad(val nombre: String) {
        override fun toString() = nombre
    }

    fun main() {
        val ciudad1 = Ciudad("Cadiz")
        val producto1 = Producto("pizza", 3.00)
        val pedido1 = Pedido(listOf(producto1), false)
        val clientes1 = Clientes("Rafa", ciudad1, listOf(pedido1))
        val tienda1 = Tienda("Mercadonna", listOf(clientes1))

        val ciudad2 = Ciudad("San Fernando")
        val producto2 = Producto("Paquete de Patatas", 1.00)
        val pedido2 = Pedido(listOf(producto2), true)
        val clientes2 = Clientes("Ruth", ciudad2, listOf(pedido2))
        val tienda2 = Tienda("Coviran", listOf(clientes2))

        val ciudad3 = Ciudad("Chiclana")
        val producto3 = Producto("Kit-Kat", 1.00)
        val pedido3 = Pedido(listOf(producto3), false)
        val clientes3 = Clientes("Ruth", ciudad3, listOf(pedido3))
        val tienda3 = Tienda("Carrefour Express", listOf(clientes3))

        val ciudad4 = Ciudad("Puerto Real")

        println(tienda1.obtenerClientesConPedidosSinEngregar())
    }