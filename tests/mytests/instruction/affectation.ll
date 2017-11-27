; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%test = alloca i32
%tmp1 = mul i32 2, 30
%tmp2 = sub i32 10, %tmp1
store i32 %tmp2, i32* %test
ret i32 0
}

