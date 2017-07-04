----------------------------- MODULE lab_6_FIFO -----------------------------
EXTENDS Naturals,Sequences,TLC
CONSTANT Data
VARIABLE buffer

FIFOini == buffer = <<>> \* Empty buffer
                          

Send ==  /\ Len (buffer) < 4  \*there is exists an element in data 
         /\ \E d \in Data : buffer'= Append (buffer,d) \* Buf next state is after adding value of d into it.
         /\ Print(<<"Send", buffer>>,TRUE) \* Print Buf after satisfying all condition above
        
Receive == /\ Len(buffer) > 0 \*IF length of Buff more then 0 messages
          /\ buffer' = Tail (buffer) \* Delete a message
           /\ Print (<<"Receive", buffer>>,TRUE) \* Print Buf after satisfying all condition above
           
          
Liveness == [] <> ( Len (buffer) = 0 \/ Len (buffer) = 3) \* 8.Liveness property 
  
 Next == Send \/ Receive   \*next predicate
 
 
-----------------------------------------------------------------------------
 
=============================================================================
\* Modification History
\* Last modified Wed Nov 19 10:00:59 SGT 2014 by FSK 10B
\* Created Wed Nov 19 08:18:17 SGT 2014 by FSK 10B

