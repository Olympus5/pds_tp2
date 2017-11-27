; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%tmp1 = mul i32 10000000, 4
%tmp2 = mul i32 32, %tmp1
%tmp3 = mul i32 4, %tmp2
ret i32 %tmp3
}

