const countShowBoxForValidate = document.createElement("p")
const getTextCount= (targetElm)=>{
    targetElm.addEventListener("keyup",(e)=>{
        const textCount = e.target.value.length;
        const label =e.target.previousElementSibling;

        countShowBoxForValidate.innerText=`${label.innerText}:${textCount}文字`;
        e.target.after(countShowBoxForValidate);
//        putTextCount.innerText=e.target;
//        console.log(e);
//        console.log(e.target);
    });
}

document.addEventListener("click",(e)=>{
    getTextCount(e.target);
});

