class turn():
    def __init__(self,text):
        self.colours = {"blue":0,"red":0,"green":0}
        self.text = text
        self.cubes = self.text.split(",")
        for i in range(0,len(self.cubes)):
            self.cubes[i] = self.cubes[i].replace(" ","").replace(",","")
            for j in self.colours.keys():
                if j in self.cubes[i]:
                    self.colours[j] = int(self.cubes[i].replace(j,""))
class game():
    def __init__(self, text):
        self.text = text.replace("Game ","").replace("\n", "")
        self.id = int(self.until(0,':'))
        self.text = self.text.replace(str(self.id) + ":","")
        self.splits = self.text.split(";")
        self.turns = []
        for i in self.splits:self.turns.append(turn(i))
    def until(self,start,c):#scans text from start, returns a string
        toRet = []
        for i in range(start,len(self.text)-(-1+start)):
            if self.text[i] == c:return ''.join(toRet)
            toRet.append(self.text[i])
        return ''.join(toRet)
    def printself(self):
        print(self.id)
        for i in self.turns:
            for j in i.colours.keys():
                print(j, str(i.colours[j]))
            print()
    def minPower(self):
        colours = {"blue":0,"red":0,"green":0}
        for i in colours.keys():
            for j in self.turns:
                if j.colours[i] > colours[i]: colours[i] = j.colours[i]
        return colours["blue"]*colours["red"]*colours["green"]
def check(r,g,b, game):
    for j in game.turns:
        if not( (j.colours["blue"] <= b) and (j.colours["green"] <= g) and (j.colours["red"] <= r)):
            return False
    return True
inp = open("input2.txt","r").readlines()

games = []
for i in inp:games.append(game(i))
n = 0
for i in games:
    n += i.minPower()
print(n)
            
        
