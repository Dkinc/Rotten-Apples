define(function(){
    return {
        pageGroups: [{"id":"8b9d535b-d83a-58d5-c3d9-47c4b40fee82","name":"Default group","pages":[{"id":"7ae26e12-0d7a-9a4e-3864-eb12d7e659a5","name":"Home-page"},{"id":"75a389b3-0b83-9262-628b-c57105cb79dd","name":"Log-in screen"},{"id":"a66aeb33-1a4d-5905-72d0-bd4cbc6b3d19","name":"Acc creation"},{"id":"b72ee0a9-6e90-2b8d-0c82-6cec0bbdd02d","name":"Example game page"},{"id":"c08a879c-570c-1ff1-f76e-73c6fa29b664","name":"Scrn Shot preview"},{"id":"77389127-ddd8-bd3a-56b1-79fed1b88f1a","name":"Home-page - loged in"},{"id":"fcf72686-9c00-c3f6-c33c-b93a357fad20","name":"MyAcc"},{"id":"453ef859-311c-325b-9a8a-f54c3064953a","name":"MyAcc info input"},{"id":"a40b7168-4404-68b5-b2d9-9cb7c40b24f3","name":"MyAcc info chage commit"}]}],
        downloadLink: "//services.ninjamock.com/html/htmlExport/download?shareCode=MR9BD&projectName=Copy of Rotten Apples",
        startupPageId: 0,

        forEachPage: function(func, thisArg){
        	for (var i = 0, l = this.pageGroups.length; i < l; ++i){
                var group = this.pageGroups[i];
                for (var j = 0, k = group.pages.length; j < k; ++j){
                    var page = group.pages[j];
                    if (func.call(thisArg, page) === false){
                    	return;
                    }
                }
            }
        },
        findPageById: function(pageId){
        	var result;
        	this.forEachPage(function(page){
        		if (page.id === pageId){
        			result = page;
        			return false;
        		}
        	});
        	return result;
        }
    }
});
