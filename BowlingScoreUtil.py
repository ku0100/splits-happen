#!/usr/bin/python

def BowlingScoreUtil(scoreLine):
    
    scoreList = list(scoreLine)
    i = 0
    x = 0
    bowlingScore = 0

    while i < len(scoreList):
        # replace any strikes with 10 value
        if scoreList[i] is "X":
            scoreList[i] = 10
        # replace any fails with 0 value
        elif scoreList[i] is "-":
            scoreList[i] = 0
        else:
            try:
                # if score is not a spare then add as int
                scoreList[i] = int(scoreList[i])
            except:
                # if score is spare, leave as-is for now
                pass
        i += 1

    while x < len(scoreList):
        # if we have moved into the 10th frame
        if x >= len(scoreList) - 3:
            if scoreList[x] is "/":
                # in final frame if a spare is rolled
                bowlingScore = bowlingScore + (10 - scoreList[x - 1])
            else:
                bowlingScore += scoreList[x]
            x += 1
        # if strike is rolled
        elif scoreList[x] is 10:
            bowlingScore = bowlingScore + 10 + scoreList[x + 1]
            # if spare rolled after a strike
            if scoreList[x + 2] is "/":
                bowlingScore = bowlingScore + (10 - scoreList[x + 1])
            # if not spare rolled after strike
            else:
                bowlingScore += scoreList[x + 2]
            x += 1
        # if spare is rolled
        elif scoreList[x] is "/":
            bowlingScore = bowlingScore + (10 - scoreList[x - 1]) + scoreList[x + 1]
            x += 1
        # rolled 0-9
        else:
            bowlingScore += scoreList[x]
            x += 1

    print(bowlingScore)

BowlingScoreUtil("XXXXXXXXXXXX")
BowlingScoreUtil("9-9-9-9-9-9-9-9-9-9-")
BowlingScoreUtil("5/5/5/5/5/5/5/5/5/5/5")
BowlingScoreUtil("X7/9-X-88/-6XXX81")
