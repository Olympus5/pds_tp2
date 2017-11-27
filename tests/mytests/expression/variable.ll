; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%test = alloca i32
%test1 = alloca i32
%tmp1 = load i32, i32* test1
%tmp2 = add i32 %tmp1, 32
%tmp3 = sub i32 4, %tmp2
store i32 %tmp3, i32* %test
ret i32 0
}

