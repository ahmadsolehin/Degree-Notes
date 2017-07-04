--------------------------- MODULE lab_1_CB13006 ---------------------------
EXTENDS Naturals
VARIABLE hr, min

HCini == /\ hr \in (1 .. 12)
         /\ min \in (1 .. 60)

HCnxt == /\hr' = IF hr # 12 THEN hr + 1 ELSE 1
        /\ min'  = IF min # 60 THEN min + 1 ELSE 1

HC == HCini /\ [][HCnxt]_ hr

HCnxt2 == hr' =(hr%12)+1

HC2 == HCini /\ [][HCnxt2]_ hr

------------------------------------------------------------------------------
THEOREM HC => []HCini 
=============================================================================
\* Modification History
\* Last modified Wed Oct 29 09:13:04 SGT 2014 by FSK 10B
\* Created Wed Oct 29 08:10:26 SGT 2014 by FSK 10B
