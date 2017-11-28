; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%test = alloca i32
%tmp1 = sub i32 2, 3
%tmp2 = mul i32 5, %tmp1
%tmp3 = add i32 %tmp2, 17
store i32 %tmp3, i32* %test
ret i32 0
}

