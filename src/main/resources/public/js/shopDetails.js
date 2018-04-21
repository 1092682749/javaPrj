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
var buyForm = document.getElementById('buyForm');
var goodsNumberInput = document.getElementById('goods_num');
var sAddTimeInput = document.getElementById('s_add_time');
// var tipNumber = document.getElementById('tipNumber');
var date = Date();
var goodsNumber = parseInt(intNumber.innerHTML);
var flag = false;
var shoppingCartObject = {
    s_add_time:date,
    goods_id:parseInt(goodsId),
    goods_num:goodsNumber,
    s_member_id:memberId
};

var tipNum = parseInt(tipNumber.innerHTML);
console.log("tipNum:"+tipNum);
console.log(enter);
// console.log(parseInt(intNumber));
console.log(memberId);
if(tipNum == 0)
{
    tipNumber.style.display = "none";
}
enter.onclick = function (){
    var shoppingCart = JSON.stringify(shoppingCartObject);
    if (flag)
    {
        sAddTimeInput.value = date;
        goodsNumberInput.value = goodsNumber;
        buyForm.submit();
        form.append("shoppingCart",shoppingCart);
    }else{
        var num;
        tipNumber.style.display = "block";
        $.ajax({
            url:'/shopping/cart/addCart',
            type:'post',
            cache:false,
            data:shoppingCart,
            contentType:'application/json',
            dataType:'json',
            success : function(data){
                console.log("ajax"+data.cartNum);
                num = data.cartNum;
                tipNumber.innerHTML = num;
            }
        });

    }
};

add.onclick = function (){
    var number = intNumber.innerHTML;
    var count =parseInt(number) + 1;
    console.log();
    intNumber.innerHTML = count + "";
    goodsNumber++;
    shoppingCartObject.goods_num = goodsNumber;
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
        shoppingCartObject.goods_num = goodsNumber;
    }
};
console.log(footRR);
console.log(footRL);
console.log(closeImg);
// slider.style.right = "0";
// slider.style.backgroundColor = "gray";
//点击立即购买
footRR.onclick = function (){
    buyNew.style.display = "block";
    flag = true;
};
//点击加入购物车
footRL.onclick = function () {
    buyNew.style.display = "block";
    flag = false;
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