# Course Project: Hexagon Tile Puzzle in Java

Solve a 7 pieces Hexagon Tile Puzzle, which requires to place total 7 tiles from center to 6 sides and match the color on every adjacent tile using Recrsion

![phpWAEUy4](https://github.com/scottsun2020/hexagon_tile/assets/59678188/8263abd1-a5de-48af-a70e-8c640bf3c3ab)

# Sample Solution

Solution #1----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: G   G   R   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #1: O   R   B   B   O   O   
Position 6 : Tile #4: O   O   O   R   O   R   
Position 7 : Tile #7: P   O   O   O   P   P   

Solution #2----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: G   G   R   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #1: O   R   B   B   O   O   
Position 6 : Tile #7: O   O   O   P   P   P   
Position 7 : Tile #4: R   O   O   O   R   O   

Solution #3----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: G   G   R   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #4: O   R   O   R   O   O   
Position 6 : Tile #1: O   O   O   R   B   B   
Position 7 : Tile #7: P   O   O   O   P   P   

Solution #4----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: G   G   R   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #4: O   R   O   R   O   O   
Position 6 : Tile #7: O   O   O   P   P   P   
Position 7 : Tile #1: B   O   O   O   R   B   

Solution #5----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: G   G   R   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #4: O   R   O   O   O   R   
Position 6 : Tile #1: O   O   R   B   B   O   
Position 7 : Tile #7: P   O   O   O   P   P   

Solution #6----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: R   G   G   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #1: O   R   B   B   O   O   
Position 6 : Tile #4: O   O   O   R   O   R   
Position 7 : Tile #7: P   O   O   O   P   P   

Solution #7----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: R   G   G   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #1: O   R   B   B   O   O   
Position 6 : Tile #7: O   O   O   P   P   P   
Position 7 : Tile #4: R   O   O   O   R   O   

Solution #8----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: R   G   G   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #4: O   R   O   R   O   O   
Position 6 : Tile #1: O   O   O   R   B   B   
Position 7 : Tile #7: P   O   O   O   P   P   

Solution #9----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: R   G   G   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #4: O   R   O   R   O   O   
Position 6 : Tile #7: O   O   O   P   P   P   
Position 7 : Tile #1: B   O   O   O   R   B   

Solution #10----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #2: G   G   G   R   O   R   
Position 3 : Tile #6: R   G   G   G   R   G   
Position 4 : Tile #5: G   G   G   R   R   R   
Position 5 : Tile #4: O   R   O   O   O   R   
Position 6 : Tile #1: O   O   R   B   B   O   
Position 7 : Tile #7: P   O   O   O   P   P   

Solution #11----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #5: G   G   G   R   R   R   
Position 3 : Tile #6: G   G   R   G   R   G   
Position 4 : Tile #2: G   G   G   R   O   R   
Position 5 : Tile #1: O   O   R   B   B   O   
Position 6 : Tile #7: O   O   O   P   P   P   
Position 7 : Tile #4: O   R   O   O   O   R   

Solution #12----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #5: G   G   G   R   R   R   
Position 3 : Tile #6: G   G   R   G   R   G   
Position 4 : Tile #2: G   G   G   R   O   R   
Position 5 : Tile #7: O   O   P   P   P   O   
Position 6 : Tile #1: O   O   O   R   B   B   
Position 7 : Tile #4: O   R   O   O   O   R   

Solution #13----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #5: G   G   G   R   R   R   
Position 3 : Tile #6: R   G   G   G   R   G   
Position 4 : Tile #2: G   G   G   R   O   R   
Position 5 : Tile #1: O   O   R   B   B   O   
Position 6 : Tile #7: O   O   O   P   P   P   
Position 7 : Tile #4: O   R   O   O   O   R   

Solution #14----------------------------------
                      SA  SB  SC  SD  SE  SF
Position 1 : Tile #3: R   R   R   O   O   O   
Position 2 : Tile #5: G   G   G   R   R   R   
Position 3 : Tile #6: R   G   G   G   R   G   
Position 4 : Tile #2: G   G   G   R   O   R   
Position 5 : Tile #7: O   O   P   P   P   O   
Position 6 : Tile #1: O   O   O   R   B   B   
Position 7 : Tile #4: O   R   O   O   O   R  
