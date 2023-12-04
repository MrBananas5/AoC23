inp = open("input.txt","r").readlines()
n = 0
digs = ["one","two","three","four","five","six","seven","eight","nine"]

digsDict = {"oneight":"18","threeight":"38","fiveight":"58","sevenine":"79","eightwo":"82","nineight":"98","sevenineight":"798","eighthree":"83","twone":"21","twoneight":"218"}
def isint(inp): return (inp.upper() == inp.lower() and not (inp == "\n"))

def findin (toFind, stri):
    newline = ""
    foundlen = 0
    stri
    print(stri)

for i in inp:
    newline = i
    print(i)
    for j in digsDict.keys():
        newline = newline.replace(j, digsDict[j])
    for j in digs:
        newline = newline.replace(j, str(digs.index(j)+1))
    print(newline)
    
    first = ""
    for c in newline:
        if isint(c): first = c
    last = ""
    for c in newline[::-1]:
        if isint(c): last = c
    print(int(last+first))
    n+= int(last + first)
print(n)    
