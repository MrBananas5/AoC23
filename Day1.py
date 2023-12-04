inp = open("input1.txt","r").readlines()
n = 0
digs = ["one","two","three","four","five","six","seven","eight","nine"]

digsDict = {"oneight":"18","threeight":"38","fiveight":"58","sevenine":"79","eightwo":"82","nineight":"98","sevenineight":"798","eighthree":"83","twone":"21","twoneight":"218"} #overlaps (one eight = oneight)
def isint(inp): return (inp.upper() == inp.lower() and not (inp == "\n"))#forgor .isdigit() exists

for i in inp:
    newline = i # preserves the original input in case i wanted it later
    print(i)
    for j in digsDict.keys(): #for each overlapping number string
        newline = newline.replace(j, digsDict[j]) #replace with number
    for j in digs: # for each normal number string
        newline = newline.replace(j, str(digs.index(j)+1)) # replace with its index +1 (its value)
    print(newline)
    
    first = ""
    for c in newline: 
        if isint(c): first = c
    last = ""
    for c in newline[::-1]: #looks through backwards for numbers
        if isint(c): last = c
    print(int(last+first))# lotsa prints sorry
    n+= int(last + first)
print(n)    
