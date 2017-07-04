----------------------------- MODULE lab_6_FIFO -----------------------------
EXTENDS Naturals,Sequences,TLC
VARIABLE buffer

FIFOini == buffer = <<>> 

Send == /\ Len (buffer) < 2
        /\  buffer' = Append (buffer,9)
        
Receive == /\ buffer # <<>>
          /\ buffer' = Tail (buffer)
          /\ Print (<<"Tail", buffer>>,TRUE)
          
  
  Next == Send \/ Receive  
      
          
----------------------------------------------------------------------------
THEOREM Spec == FIFOini /\ [] [Next]_<<buffer>>     

=============================================================================
\* Modification History
\* Last modified Wed Nov 19 09:26:05 SGT 2014 by FSK 10B
\* Created Wed Nov 19 08:18:17 SGT 2014 by FSK 10B
