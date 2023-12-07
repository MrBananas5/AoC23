inp = [i.replace("\n","") for i in open("input7.txt","r")]
values = ["2","3","4","5","6","7","8","9","T","J","Q","K","A"]
#move J for part 2.

hands = [] # to be populated with hand objects
class hand():
    def __init__(self,line):
        hands.append(self)
        self.cards  = line.split(" ")[0]
        self.bid = int (line.split(" ")[1])
        counts = {} #stores counts in a dictionary
        for i in self.cards:counts[i] = self.cards.count(i)
        #counts["J"] = 0 #uncomment for part 2
        self.counts = [counts[i] for i in counts.keys()] #converts the dictionary to a list
        self.counts.sort(reverse=True) # sorts it (now we have the type, pretty much)
        #self.counts[0] += self.cards.count("J")  #uncomment for part 2
    def compare(self,to): # does not store type so it is a mess of if/elif statements
        if to.counts[0] > self.counts[0]: return False#compares type
        elif to.counts[0] < self.counts[0] : return True
        elif self.counts[0] in [3,2] and to.counts[1] > self.counts[1]: return False# for full house and two pair
        elif self.counts[0] in [3,2] and to.counts[1] < self.counts[1]: return True
        for i in range(0,5): #comparing values
            if values.index(to.cards[i]) > values.index(self.cards[i]) : return False
            elif values.index(to.cards[i]) < values.index(self.cards[i]): return True
        return False#at this point, they would be identical

def swap(lis,p1,p2): # swaps the data in p1 with data in p2
    temp = lis[p1]
    lis[p1] = lis[p2]
    lis[p2] = temp
    
for i in inp: hand(i)

for i in range(0,len(hands)-1) : #BUBBLE SORT I LOVE BUBBLE SORT
    swapped = False
    for j in range(0,len(hands)-1) :
        if (hands[j].compare(hands[j+1])) :
            swap(hands,j, j+1)
            swapped = True
    if ( not swapped):
        break
        
n = 0
for i in range(0,len(hands)):
    #print(hands[i].cards,hands[i].bid,i+1,hands[i].bid*(i+1))#prints data for troubleshooting
    n += (i+1)*hands[i].bid
print(n)
