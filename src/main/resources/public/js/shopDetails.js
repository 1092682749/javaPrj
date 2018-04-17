var slider = document.getElementsByClassName('slider-line')[0];
var goodsInfoLeft = document.getElementsByClassName('goods-info')[0];
var goodsInfoRight = document.getElementsByClassName('goods-info')[1];
var leftInfo = document.getElementById('left-info');
var rightInfo = document.getElementById('right-info');
var buyNew = document.getElementsByClassName('buy-new')[0];
var footRR = document.getElementsByClassName('foot-right-right')[0];
var footRL = document.getElementsByClassName('foot-right-left')[0];
var closeImg = document.getElementById('closeImg');
var add = document.getElementsByClassName('add')[0];
var reduce = document.getElementsByClassName('reduce')[0];
var intNumber = document.getElementsByClassName('int-number')[0];

console.log(footRR);
console.log(footRL);
console.log(closeImg);

add.onclick =function (){
    var number = intNumber.innerHTML;
    var count =parseInt(number) + 1;
    console.log();
    intNumber.innerHTML = count + "";
};

reduce.onclick = function() {
    var number = intNumber.innerHTML;
    var count =parseInt(number) - 1;
    if (count < 1)
    {
        return;
    }else{
        intNumber.innerHTML = count + "";
    }
};
console.log(footRR);
console.log(footRL);
console.log(closeImg);
// slider.style.right = "0";
// slider.style.backgroundColor = "gray";
footRR.onclick = function (){
    buyNew.style.display = "block";
};
footRL.onclick = function () {
    buyNew.style.display = "block";
};
closeImg.onclick = function (){
    buyNew.style.display = "none";
};
goodsInfoLeft.onclick = function () {
    slider.style.left = "0";
    leftInfo.style.display = "block";
    rightInfo.style.display = "none";
};
goodsInfoRight.onclick = function () {
    slider.style.left = "50%";
    leftInfo.style.display = "none";
    rightInfo.style.display = "block";
};