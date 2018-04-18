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
var enter = document.getElementsByClassName('enter')[0];
var tipNumber = document.getElementsByClassName('tipNumber')[0];
var goodsIdInput = document.getElementById('goodsId');
var memberIdInput = document.getElementById('memberID');
var memberId = memberIdInput.getAttribute('value');
var goodsId = goodsIdInput.getAttribute('value');
var date = Date();
var goodsNumber = parseInt(intNumber.innerHTML);
var shoppingCartObject = {
    s_add_time:date,
    goods_id:parseInt(goodsId),
    goods_num:goodsNumber,
    s_member_id:memberId
};
var shoppingCart = JSON.stringify(shoppingCartObject);


console.log(enter);
// console.log(parseInt(intNumber));
console.log(memberId);

enter.onclick = function (){
    console.log(111111);
    $.ajax({
        url:'/shopping/cart/number',
        type:'post',
        cache:false,
        data:shoppingCart,
        contentType:'application/json',
        dataType:'json'
    });
    // var xmlHttpRequest;
    // if (window.XMLHttpRequest)
    // {
    //     xmlHttpRequest = new XMLHttpRequest();
    // }else {
    //     xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    // }
    // xmlHttpRequest.open("post","/shopping/cart/number",true);
    // xmlHttpRequest.send();
    // xmlHttpRequest.onreadystatechange = function () {
    //     if (xmlHttpRequest.status == 200&&xmlHttpRequest.readyState == 4)
    //     {
    //         var text = xmlHttpRequest.responseText;
    //         var numberObject = JSON.parse(text);
    //         tipNumber.innerHTML = numberObject.number;
    //     }
    // }
};

add.onclick = function (){
    var number = intNumber.innerHTML;
    var count =parseInt(number) + 1;
    console.log();
    intNumber.innerHTML = count + "";
    goodsNumber++;
};

reduce.onclick = function() {
    var number = intNumber.innerHTML;
    var count =parseInt(number) - 1;
    if (count < 1)
    {
        return;
    }else{
        intNumber.innerHTML = count + "";
        goodsNumber--;
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