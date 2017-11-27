; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%test = alloca i32
%tmp1 = sub i32 4, 3
store i32 %tmp1, i32* %test
%tmp2 = load i32, i32* %test
%tmp3 = sub i32 %tmp2, 1
store i32 %tmp3, i32* %test
ret i32 0
}

