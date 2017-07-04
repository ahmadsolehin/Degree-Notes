--------------------------- MODULE Lab_4_CB15003 ---------------------------
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

\* After \/ is changed into AND /\ the process will stop immediately. Its is called deadlock
----------------------------------------------------------------------------
THEOREM Spec => [] TypeInvariant        
=============================================================================
\* Modification History
\* Last modified Tue Mac 28 09:53:46 SGT 2017 by FSK 1
\* Last modified Tue Mac 28 09:49:31 SGT 2017 by FSK 1
\* Created Tue Mac 28 08:10:31 SGT 2017 by FSK 1
