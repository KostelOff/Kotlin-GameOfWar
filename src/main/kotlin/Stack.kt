open class Stack<T> {
    val list = mutableListOf<T>()
    fun push(item: T){
        list.add(item)

    }
    fun pop ():T? {
        return if(isEmpty()) {null} else {list.removeLast()}
    }
    fun isEmpty():Boolean{
        return list.size <= 0
    }
}