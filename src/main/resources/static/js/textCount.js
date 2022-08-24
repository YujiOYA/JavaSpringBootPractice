const countShowBoxForValidate = document.createElement("p")
const getTextCount= (targetElm)=>{
    targetElm.addEventListener("keyup",(e)=>{
        const textCount = e.target.value.length;
        const label =e.target.previousElementSibling;
        countShowBoxForValidate.innerText=`${label.innerText}:${textCount}文字`;
        e.target.after(countShowBoxForValidate);
    });
}

document.addEventListener("click",(e)=>{
    getTextCount(e.target);
});

