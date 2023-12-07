inp = [i.replace("\n","") for i in open("input7.txt","r")]
values = ["J","2","3","4","5","6","7","8","9","T","Q","K","A"]


hands = [] # to be populated with hand objects
class hand():
    def __init__(self,line):
        hands.append(self)
        self.cards  = line.split(" ")[0]
        self.bid = int (line.split(" ")[1])
        counts = {}
        for i in self.cards:counts[i] = self.cards.count(i) 
        counts["J"] = 0
        self.counts = [counts[i] for i in counts.keys()]
        self.counts.sort(reverse=True)
        self.counts[0] += self.cards.count("J") 
    def compare(self,to): # not
        if to.counts[0] > self.counts[0]: return False
        elif to.counts[0] < self.counts[0] : return True
        elif self.counts[0] in [3,2] and to.counts[1] > self.counts[1]: return False
        elif self.counts[0] in [3,2] and to.counts[1] < self.counts[1]: return True
        for i in range(0,5):
            if values.index(to.cards[i]) > values.index(self.cards[i]) : return False
            elif values.index(to.cards[i]) < values.index(self.cards[i]): return True
        return True

def swap(lis,p1,p2):
    temp = lis[p1]
    lis[p1] = lis[p2]
    lis[p2] = temp
    
for i in inp: hand(i)

for i in range(0,len(hands)-1) :
    swapped = False
    for j in range(0,len(hands)-1) :
        if (hands[j].compare(hands[j+1])) :
            swap(hands,j, j+1)
            swapped = True
    if ( not swapped):
        break
        
n = 0
for i in range(0,len(hands)):
    #print(hands[i].cards,hands[i].bid,i+1,hands[i].bid*(i+1))
    n += (i+1)*hands[i].bid
print(n)
