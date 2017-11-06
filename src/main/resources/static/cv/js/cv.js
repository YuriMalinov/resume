var app = new Vue({
    el: '#resume',
    data: {
        loaded: false,
        experienceDetails: false,
        resume: null
    },
    mounted: function () {
        var that = this;
        $.getJSON('/cv/data').then(function (data) {
            that.resume = data;
            that.loaded = true;
        })
    }
});