; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%n = alloca i32
%n2 = alloca i32
%tmp1 = load i32, i32* %n2
%tmp2 = add i32 3, 4
%tmp3 = mul i32 %tmp1, %tmp2
store i32 %tmp3, i32* %n
ret i32 0
}

