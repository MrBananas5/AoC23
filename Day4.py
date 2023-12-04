inp = open("input4.txt","r").readlines()
def remove(l,c): #returns a (list) copy of iterable l, with no instances of c
    toRet = []
    for i in l:
        if not i == c:toRet.append(i)
    return toRet
class ticket(): #ticket class
    def __init__(self,text):
        self.text = text.replace("\n","")# removes EoL character
        self.numbers = list(self.text) 
        self.numbers = self.text.split(":")[1]
        self.id = int(self.text.split(":")[0].replace("Card ","")) # splits it by colon, and removes 'Card ' - to get the ID of the ticket
        self.winners = [int(i) for i in remove(self.numbers.split("|")[0].split(" "),"")] #the numbers on the left (separated by ' ') - removes empty parts too
        self.numbers = [int(i) for i in remove(self.numbers.split("|")[1].split(" "),"")] #the numbers on the right (separated by ' ')
        self.matches = [] #prepares matches 
        
        self.countWinners()
        
        #print(self.id)
        #print(self.matches)
        #print(self.points,"\n")

    def countWinners(self):#counts the points and stores the matches for later use
        n = 0
        for i in self.winners:
            for c in self.numbers:
                if i==c:
                    n+=1
                    self.matches.append(i)

        if n == 0: self.points = 0
        else: self.points = 2**(n-1)

tickets = [ticket(i) for i in inp]

copies = [] # stores the numbers of each ticket
n = 0
for i in tickets:
    copies.append(i.id) #there exists at least one copy of each ticket
    k = 0 #used to get the total number of each ticket
    for j in copies: #looks at every copy of every ticket
        if j == i.id: 
            k+=1
            n+=1
            for c in range(1,1+len(i.matches)):copies.append(i.id+c)#stores the number of every ticket it needs to 
    print(i.id,len(i.matches),k,n)


        
print(n)
