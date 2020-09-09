var Day;
(function (Day) {
    Day[Day["SUNDAY"] = 0] = "SUNDAY";
    Day[Day["MONDAY"] = 1] = "MONDAY";
    Day[Day["TUESDAY"] = 2] = "TUESDAY";
    Day[Day["WEDNESDAY"] = 3] = "WEDNESDAY";
})(Day || (Day = {}));
var sun = Day.SUNDAY;
var mon = Day.MONDAY;
console.log("sunday value=" + sun);
console.log("monday value=" + mon);
