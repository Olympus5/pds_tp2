; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%tmp1 = udiv i32 3, 2
%tmp2 = sub i32 32, 1
%tmp3 = mul i32 42, %tmp2
%tmp4 = add i32 %tmp1, %tmp3
ret i32 %tmp4
}

