; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%return = alloca i32
%tmp1 = add i32 4, 3
store i32 %tmp1, i32* %return
ret i32 0
}

