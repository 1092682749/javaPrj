var total = document.getElementsByClassName('total')[0];
var sumPrice = 0;
function selectAll() {
    var checkboxArr = document.getElementsByClassName("check");
    var dad = document.getElementById('dad');
    if (dad.checked == true){
        for (var i= 0 ; i <= checkboxArr.length-1 ; i++){
            checkboxArr[i].checked = true;
        }
    }else {
        for (var i= 0 ; i <= checkboxArr.length-1 ; i++){
            checkboxArr[i].checked = false;
        }
    }
    countSum();
}
function countSum() {
    sumPrice = 0;
    var sumNumber = 0;
    var goodsDivList = document.getElementsByClassName('goodsDiv');
    for (var i = 0 ; i < goodsDivList.length ; i++){
        var check = goodsDivList[i].getElementsByClassName('check')[0];
        if (check.checked == true)
        {
            var goodsPriceStr = goodsDivList[i].getElementsByClassName('goodsPrice')[0].innerHTML;
            var end_p = goodsPriceStr.indexOf('元');
            var goodsPrice = parseInt(goodsPriceStr.substring(1,end_p));
            var goodsNumberStr = goodsDivList[i].getElementsByClassName('goodsNumber')[0].innerHTML;
            var goodsNumber = parseInt(goodsNumberStr.substring(1,goodsNumberStr.length));
            sumPrice += goodsPrice*goodsNumber;
            sumNumber += goodsNumber;
        }
    }
    total.innerHTML = '合计：￥' + sumPrice + '（共' + sumNumber + '件）';
}