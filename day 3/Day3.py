inp = [i.replace("\n","") for i in open("input3.txt","r").readlines()]

class num(): #number object
    def __init__(self,n,x,y): #n is the its number(String), # x is its end position
        self.n = int(n)
        self.poss = [(i,y) for i in range(x-len(n),x)] # creates a list of pairs, for each coordinate it has

class symb(): #symbol object
    def __init__(self, s, x,y): #s is the symbol, x and y are its coordinate
        self.s = s
        self.pos = (x,y) #useless in the end
        self.poss = []#creates a list of pairs, for each surrounding coordinate, and its own ig
        for i in range(-1,2):
            for j in range(-1,2):
                self.poss.append((x+i,y+j))
    def getMachines(self):#populates the allmacs list and its own
        self.macs = []
        for i in self.poss: # for each of my posisitons
            for j in nums: 
                for c in j.poss: #for the coordinate the number has
                    if c[0] == i[0] and c[1] == i[1]: #if my posistion is the same as the coordinate
                        if not j in allmacs: 
                            ##print(i,j.n,self.s)
                            allmacs.append(j) 
                            self.macs.append(j)
                            break
    def getGears(self):#populates the gears list and assigns a number
        if self.s == "*" and len(self.macs) == 2: #if i meet the criteria of a gear
            gears.append(self) 
            self.n = self.macs[0].n*self.macs[1].n #calculate my value
gears = [] #lists to be populated
nums = []
symbs = []
allmacs = []
builder = []
for y in range(0,len(inp)):
    for x in range(0,len(inp[y])): #reads each posistion
        if (inp[y][x].isdigit()): builder.append(inp[y][x])#if it is a digit, adds it to a builder list
        elif (inp[y][x] != '.'): # if it is a symbol (and not a digit
            symbs.append(symb(inp[y][x],x,y)) # creates a symbol object
            if len(builder) > 0: #if the builder has length
                nums.append(num(''.join(builder),x,y)) #create a number object
                builder = [] #reset the builder
        elif len(builder) > 0: #same as above, (I'm being lazy)
            nums.append(num(''.join(builder),x,y))
            builder = []
    if len(builder) > 0:
            nums.append(num(''.join(builder),x,y))
            builder = []
            
for i in symbs:i.getMachines()#populate the machine parts list.
    
n = sum([i.n for i in allmacs]) # 539590 - my solution to part 1
print(n)

for i in symbs:i.getGears()
g = sum([i.n for i in gears]) #80703636 - my solution to part 2 
print(g)
