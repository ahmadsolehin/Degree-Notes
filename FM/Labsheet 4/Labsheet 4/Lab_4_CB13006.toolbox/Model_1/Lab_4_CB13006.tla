--------------------------- MODULE Lab_4_CB13006 ---------------------------
EXTENDS Naturals, TLC
VARIABLE val,ack

TypeInvariant == /\ val \in (1 .. 12)\* declaration value
                 /\ ack \in {0,1} \* data in value
 
\* For three Data Sets                
\* Data = {d1, d2, d3}
\* rdy = {0,1}
\* ack = {0,1}                 
                 
\* Distinct State = {0,1} x {0,1} x {0,1}
\*                  3 x 2 x 2 = 12


\* For two Data Sets                
\* Data = {add,delete}
\* rdy = {0,1}
\* ack = {0,1}                 
                 
\* Distinct State = {0,1} x {0,1} x {0,1}
\*                  2 x 2 x 2 = 8
                 
-----------------------------------------------------------------------------
Init == /\ val \in (1 .. 12)\* declaration value
        /\ ack = 0 
        
Send == /\ ack = 0 
        /\ val' \in (1 .. 12) \* declaration value
        /\ UNCHANGED ack
        /\ Print (<<"Send", val>>,TRUE) \* command for print
     
Rcv ==  /\ ack = 1
        /\ ack' = 1- ack
        /\ UNCHANGED <<val>>
        /\ Print (<<"Rcv", val>>,TRUE)\* command for print
        
Next == Send /\ Rcv \*next predicate
Spec == Init /\ [] [Next]_<<val,ack>> \* operation
----------------------------------------------------------------------------
THEOREM Spec => [] TypeInvariant        
=============================================================================
\* Modification History
\* Last modified Wed Nov 05 09:52:34 SGT 2014 by FSK 10B
\* Last modified Wed Nov 05 09:49:31 SGT 2014 by FSK 10B
\* Created Wed Nov 05 08:10:31 SGT 2014 by FSK 10B
