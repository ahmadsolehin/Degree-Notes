----------------------------- MODULE HourClock -----------------------------
EXTENDS Naturals
VARIABLE hr, min
HCini == /\ hr \in (1 .. 10) \* Appending the hour with 12 value in the queue
/\ min \in(1 .. 60) \* Appending the min with 60 value in the queue

HCnxt == /\ hr' = IF hr # 10 THEN hr + 1 ELSE 1 \* State the number of hour include the initial value 1
/\ min'= IF min # 60 THEN min + 1 ELSE 1 \* State the number of minute include the initial value 1

HC == HCini /\ [][HCnxt]_ <<hr, min>>
 \* Asserting that HCini is always true in hour and minute

HCnxt2 == /\ hr'=(hr%10)+1 \* To route the same formula with the value of hour
/\ min'=(min%60)+1 \* To route the same formula with the value of minute


HC2 == HCini /\[][HCnxt2]_ <<hr, min>> 
\* Asserting that HCini is always true in hour and minute

-----------------------------------------------------------------------------
THEOREM HC => []HCini

=============================================================================
\* Modification History
\* Last modified Fri Apr 14 08:51:58 SGT 2017 by FSK 1
\* Created Fri Apr 14 08:32:29 SGT 2017 by FSK 1
