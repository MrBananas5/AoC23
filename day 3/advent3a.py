file = open('input3.txt', 'r')
engineSchematics = [] # we will store the whole engine schematics here
partNumbers = [] # here we will store all the part numbers

towrite = open("real3.txt","w")
for line in file: # line by line we store the engine schematics
    line = line.strip()
    engineSchematics.append(line)

def checkForSymbols(lineNo, colNoStart, colNoEnd): # We define a function that can check if there are any symbols around a number - so if the number is a part number, which is on line lineNo in the schematics input, starts on the position colNoStart and ends on the position colNoEnd (everything is enumerated starting zero). If the number is part number it returns true, otherwise it returns False. We will use this function later.
    if colNoStart > 0: # if the number doesn't start at the first (0th) position 
        startCheck = colNoStart - 1 # we can check the character before it
        if not engineSchematics[lineNo][startCheck].isdigit() and engineSchematics[lineNo][startCheck] != '.': # if there is a symbol (no digit or .)
            return True # we got out of the function and return true because the number is a part number
    else: # the number starts at the beginning of it's line
        startCheck = 0 # we can't check before the start

    if colNoEnd == len(engineSchematics[0]) - 1: #if the number ends at the end of it's line
        endCheck = colNoEnd #we can't check behind it 
    else: # if it's not at the end
        endCheck = colNoEnd + 1 #we can check behind
        if not engineSchematics[lineNo][endCheck].isdigit() and engineSchematics[lineNo][endCheck] != '.': # if there is a symbol behind the number
            return True  # we got out of the function and return true because the number is a part number

    if lineNo > 0: # if the number is not in the first (0th) line we can check the previous line on the positions adjacent to the number
        for i in range(startCheck, endCheck + 1): # check for each position that is adjacent to the number
            if not engineSchematics[lineNo - 1][i].isdigit() and engineSchematics[lineNo - 1][i] != '.': # if there is a symbol
                return True # we got out of the function and return true because the number is a part number
    if lineNo < len(engineSchematics) - 1: # if the number is not on the last line we can check the line below
        for i in range(startCheck, endCheck + 1): # we check for the adjacent positions one by one
            if not engineSchematics[lineNo + 1][i].isdigit() and engineSchematics[lineNo + 1][i] != '.': # if there is a symbol
                return True # we got out of the function and return true because the number is a part number
    return False # if we got the whole way to here it means that we didn't find the symbol anywhere - so this number is not a part number and we return false

for lineNo in range(len(engineSchematics)): # here we start checking the engine schematics for numbers one by one
    colNo = 0 # we start checking at the first (0th) character
    while colNo < len(engineSchematics[0]): # until we check all the characters in the line (tracking them by the position colNo) we will repeat
        if engineSchematics[lineNo][colNo].isdigit(): #if the checking character is a digit
            start = colNo # we mark that it's the starting position of a number
            colNo +=1 # we move to the next character to check it
            while colNo < len(engineSchematics[lineNo]) and engineSchematics[lineNo][colNo].isdigit(): # when we didn't check the whole line yet and the consecutive characters keep being digits (the conditions have to be in this order - we need to check if we are at the end first - otherwise we might try checking character that doesn't exist - because it should be after the last character)
                colNo +=1 # we go check the next character if it's a digit
            end = colNo - 1 # last character that I checked wasn't digit anymore (or we re at the end) because we got out of the while loop. So the end of the number will be at this position
            if checkForSymbols(lineNo, start, end): # we use our function here -> if this number is a part number
                towrite.write("("+str(start)+","+str(lineNo)+") "+engineSchematics[lineNo][start:end+1]+"\n")
                partNumbers.append(int(engineSchematics[lineNo][start:end+1])) # we convert it to integer (it's string so far) and append it to the partNumbers list
        colNo +=1 # we go check the next character in the line
towrite.close()
print(sum(partNumbers)) # print the sum of all the numbers in the list
