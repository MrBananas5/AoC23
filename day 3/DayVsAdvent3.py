working = open("real3.txt","r").readlines()
broken =  open("fake3.txt","r").readlines()

for i in working:
    if not i in broken:
        print(i)
