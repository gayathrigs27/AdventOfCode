private val filename = "src/input/Day_2_1202AlarmInput"


fun programAlarm(input: List<Int>, noun: Int, verb: Int): Int {
    val opcodes = input.toMutableList()
    opcodes[1] = noun
    opcodes[2] = verb
    for (i in opcodes.indices step 4)
        when (opcodes[i]) {
            1 -> opcodes[opcodes[i + 3]] = opcodes[opcodes[i + 1]] + opcodes[opcodes[i + 2]]
            2 -> opcodes[opcodes[i + 3]] = opcodes[opcodes[i + 1]] * opcodes[opcodes[i + 2]]
            99 -> return opcodes[0]
        }
    return opcodes[0]
}

fun findInput(opcodeList: List<Int>): Int {
    for(i in 0..99) {
        for(j in 0..99) {
            if(programAlarm(opcodeList, i, j) == 19690720)
                return 100 * i + j
        }
    }
    return -1
}

fun main() {
    val opcodeList = helpers.convertInputToIntList(filename,',')
    val noun =12
    val verb =2
    println("value in position 0:${programAlarm(opcodeList,noun,verb)}")
    println("To produce 19690720 100 * noun + verb is:${findInput(opcodeList)}")
}
