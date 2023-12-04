inp = open("input4.txt","r").readlines()
def remove(l,c):
    toRet = []
    for i in l:
        if not i == c:toRet.append(i)
    return toRet
class ticket():
    def __init__(self,text):
        self.text = text.replace("\n","")
        self.numbers = list(self.text)
        self.numbers = self.text.split(":")[1]
        self.id = int(self.text.split(":")[0].replace("Card ",""))
        self.winners = [int(i) for i in remove(self.numbers.split("|")[0].split(" "),"")]
        self.numbers = [int(i) for i in remove(self.numbers.split("|")[1].split(" "),"")]
        self.matches = []
        
        self.countWinners()
        
        #print(self.id)
        #print(self.matches)
        #print(self.points,"\n")

    def countWinners(self):
        n = 0
        for i in self.winners:
            for c in self.numbers:
                if i==c:
                    n+=1
                    self.matches.append(i)

        if n == 0: self.points = 0
        else: self.points = 2**(n-1)

tickets = [ticket(i) for i in inp]

copies = []
n = 0
for i in tickets:
    copies.append(i.id)
    k = 0
    for j in copies:
        if j == i.id:
            k+=1
            n+=1
            for c in range(1,1+len(i.matches)):copies.append(i.id+c)
    print(i.id,len(i.matches),k,n)


        
print(n)
