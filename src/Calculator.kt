import javax.script.ScriptEngineManager

fun main(){
    val calculator = Calculator()
    var input = ""

    // "="입력 전까지 돌아가게
    do{
        input = readLine()!! //한줄씩 인식
        when(input){
            "1","2","3","4","5","6","7","8","9","0" -> {
                calculator.inputNum(input.toInt())
            }
            "+" -> calculator.inputPlus()
            "-" -> calculator.inputMinus()
            "*" -> calculator.inputMultiply()
            "/" -> calculator.inputDivide()
            "=" -> println(calculator.getResult())
        }
    }while (input != "=")
}
class Calculator {
    private var expression : String = ""
    private val engine = ScriptEngineManager().getEngineByName("JavaScript")

    fun inputNum(num:Int){
        // 화면에 숫자가 표시되기까지의 엄청복잡한 코드
        expression+=num
    }
    fun inputPlus(){
        expression+="+"
    }
    fun inputMinus(){
        expression+="-"
    }
    fun inputMultiply(){
        expression+="*"
    }
    fun inputDivide(){
        expression+="/"
    }
    fun getResult(): Int = engine.eval(expression) as Int  //return 생략 , eval함수 : 연산을 대신해주는 함수


}