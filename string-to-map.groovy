def input =
"""AIRLINE/DJ
FLIGHTNUMBER/183"""

public enum MessageFieldTypes {

    AIRLINE,
    FLIGHTNUMBER
    
}

def map = [:]

input.split(" *\n *").each() {
   row = it.split(" */ *")
   
   map.put(MessageFieldTypes.valueOf(row[0]), row.length == 1 ? "" : row[1])
   
}

println map[MessageFieldTypes.FLIGHTNUMBER]
println map