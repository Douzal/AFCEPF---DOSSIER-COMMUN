
!function(a){!function(){var a=function(b){var c=new a.Index;return c.pipeline.add(a.trimmer,a.stopWordFilter,a.stemmer),b&&b.call(c,c),c};a.version="0.7.0",a.utils={},a.utils.warn=function(a){return function(b){a.console&&console.warn&&console.warn(b)}}(this),a.utils.asString=function(a){return void 0===a||null===a?"":a.toString()},a.EventEmitter=function(){this.events={}},a.EventEmitter.prototype.addListener=function(){var a=Array.prototype.slice.call(arguments),b=a.pop(),c=a;if("function"!=typeof b)throw new TypeError("last argument must be a function");c.forEach(function(a){this.hasHandler(a)||(this.events[a]=[]),this.events[a].push(b)},this)},a.EventEmitter.prototype.removeListener=function(a,b){if(this.hasHandler(a)){var c=this.events[a].indexOf(b);this.events[a].splice(c,1),this.events[a].length||delete this.events[a]}},a.EventEmitter.prototype.emit=function(a){if(this.hasHandler(a)){var b=Array.prototype.slice.call(arguments,1);this.events[a].forEach(function(a){a.apply(void 0,b)})}},a.EventEmitter.prototype.hasHandler=function(a){return a in this.events},a.tokenizer=function(b){return arguments.length&&null!=b&&void 0!=b?Array.isArray(b)?b.map(function(b){return a.utils.asString(b).toLowerCase()}):b.toString().trim().toLowerCase().split(a.tokenizer.seperator):[]},a.tokenizer.seperator=/[\s\-]+/,a.tokenizer.load=function(a){var b=this.registeredFunctions[a];if(!b)throw new Error("Cannot load un-registered function: "+a);return b},a.tokenizer.label="default",a.tokenizer.registeredFunctions={default:a.tokenizer},a.tokenizer.registerFunction=function(b,c){c in this.registeredFunctions&&a.utils.warn("Overwriting existing tokenizer: "+c),b.label=c,this.registeredFunctions[c]=b},a.Pipeline=function(){this._stack=[]},a.Pipeline.registeredFunctions={},a.Pipeline.registerFunction=function(b,c){c in this.registeredFunctions&&a.utils.warn("Overwriting existing registered function: "+c),b.label=c,a.Pipeline.registeredFunctions[b.label]=b},a.Pipeline.warnIfFunctionNotRegistered=function(b){var c=b.label&&b.label in this.registeredFunctions;c||a.utils.warn("Function is not registered with pipeline. This may cause problems when serialising the index.\n",b)},a.Pipeline.load=function(b){var c=new a.Pipeline;return b.forEach(function(b){var d=a.Pipeline.registeredFunctions[b];if(!d)throw new Error("Cannot load un-registered function: "+b);c.add(d)}),c},a.Pipeline.prototype.add=function(){var b=Array.prototype.slice.call(arguments);b.forEach(function(b){a.Pipeline.warnIfFunctionNotRegistered(b),this._stack.push(b)},this)},a.Pipeline.prototype.after=function(b,c){a.Pipeline.warnIfFunctionNotRegistered(c);var d=this._stack.indexOf(b);if(-1==d)throw new Error("Cannot find existingFn");d+=1,this._stack.splice(d,0,c)},a.Pipeline.prototype.before=function(b,c){a.Pipeline.warnIfFunctionNotRegistered(c);var d=this._stack.indexOf(b);if(-1==d)throw new Error("Cannot find existingFn");this._stack.splice(d,0,c)},a.Pipeline.prototype.remove=function(a){var b=this._stack.indexOf(a);-1!=b&&this._stack.splice(b,1)},a.Pipeline.prototype.run=function(a){for(var b=[],c=a.length,d=this._stack.length,e=0;c>e;e++){for(var f=a[e],g=0;d>g&&(f=this._stack[g](f,e,a),void 0!==f&&""!==f);g++);void 0!==f&&""!==f&&b.push(f)}return b},a.Pipeline.prototype.reset=function(){this._stack=[]},a.Pipeline.prototype.toJSON=function(){return this._stack.map(function(b){return a.Pipeline.warnIfFunctionNotRegistered(b),b.label})},a.Vector=function(){this._magnitude=null,this.list=void 0,this.length=0},a.Vector.Node=function(a,b,c){this.idx=a,this.val=b,this.next=c},a.Vector.prototype.insert=function(b,c){this._magnitude=void 0;var d=this.list;if(!d)return this.list=new a.Vector.Node(b,c,d),this.length++;if(b<d.idx)return this.list=new a.Vector.Node(b,c,d),this.length++;for(var e=d,f=d.next;void 0!=f;){if(b<f.idx)return e.next=new a.Vector.Node(b,c,f),this.length++;e=f,f=f.next}return e.next=new a.Vector.Node(b,c,f),this.length++},a.Vector.prototype.magnitude=function(){if(this._magnitude)return this._magnitude;for(var a,b=this.list,c=0;b;)a=b.val,c+=a*a,b=b.next;return this._magnitude=Math.sqrt(c)},a.Vector.prototype.dot=function(a){for(var b=this.list,c=a.list,d=0;b&&c;)b.idx<c.idx?b=b.next:b.idx>c.idx?c=c.next:(d+=b.val*c.val,b=b.next,c=c.next);return d},a.Vector.prototype.similarity=function(a){return this.dot(a)/(this.magnitude()*a.magnitude())},a.SortedSet=function(){this.length=0,this.elements=[]},a.SortedSet.load=function(a){var b=new this;return b.elements=a,b.length=a.length,b},a.SortedSet.prototype.add=function(){var a,b;for(a=0;a<arguments.length;a++)b=arguments[a],~this.indexOf(b)||this.elements.splice(this.locationFor(b),0,b);this.length=this.elements.length},a.SortedSet.prototype.toArray=function(){return this.elements.slice()},a.SortedSet.prototype.map=function(a,b){return this.elements.map(a,b)},a.SortedSet.prototype.forEach=function(a,b){return this.elements.forEach(a,b)},a.SortedSet.prototype.indexOf=function(a){for(var b=0,c=this.elements.length,d=c-b,e=b+Math.floor(d/2),f=this.elements[e];d>1;){if(f===a)return e;a>f&&(b=e),f>a&&(c=e),d=c-b,e=b+Math.floor(d/2),f=this.elements[e]}return f===a?e:-1},a.SortedSet.prototype.locationFor=function(a){for(var b=0,c=this.elements.length,d=c-b,e=b+Math.floor(d/2),f=this.elements[e];d>1;)a>f&&(b=e),f>a&&(c=e),d=c-b,e=b+Math.floor(d/2),f=this.elements[e];return f>a?e:a>f?e+1:void 0},a.SortedSet.prototype.intersect=function(b){for(var c=new a.SortedSet,d=0,e=0,f=this.length,g=b.length,h=this.elements,i=b.elements;!(d>f-1||e>g-1);)h[d]!==i[e]?h[d]<i[e]?d++:h[d]>i[e]&&e++:(c.add(h[d]),d++,e++);return c},a.SortedSet.prototype.clone=function(){var b=new a.SortedSet;return b.elements=this.toArray(),b.length=b.elements.length,b},a.SortedSet.prototype.union=function(a){var b,c,d;this.length>=a.length?(b=this,c=a):(b=a,c=this),d=b.clone();for(var e=0,f=c.toArray();e<f.length;e++)d.add(f[e]);return d},a.SortedSet.prototype.toJSON=function(){return this.toArray()},a.Index=function(){this._fields=[],this._ref="id",this.pipeline=new a.Pipeline,this.documentStore=new a.Store,this.tokenStore=new a.TokenStore,this.corpusTokens=new a.SortedSet,this.eventEmitter=new a.EventEmitter,this.tokenizerFn=a.tokenizer,this._idfCache={},this.on("add","remove","update",function(){this._idfCache={}}.bind(this))},a.Index.prototype.on=function(){var a=Array.prototype.slice.call(arguments);return this.eventEmitter.addListener.apply(this.eventEmitter,a)},a.Index.prototype.off=function(a,b){return this.eventEmitter.removeListener(a,b)},a.Index.load=function(b){b.version!==a.version&&a.utils.warn("version mismatch: current "+a.version+" importing "+b.version);var c=new this;return c._fields=b.fields,c._ref=b.ref,c.tokenizer=a.tokenizer.load(b.tokenizer),c.documentStore=a.Store.load(b.documentStore),c.tokenStore=a.TokenStore.load(b.tokenStore),c.corpusTokens=a.SortedSet.load(b.corpusTokens),c.pipeline=a.Pipeline.load(b.pipeline),c},a.Index.prototype.field=function(a,b){var b=b||{},c={name:a,boost:b.boost||1};return this._fields.push(c),this},a.Index.prototype.ref=function(a){return this._ref=a,this},a.Index.prototype.tokenizer=function(b){var c=b.label&&b.label in a.tokenizer.registeredFunctions;return c||a.utils.warn("Function is not a registered tokenizer. This may cause problems when serialising the index"),this.tokenizerFn=b,this},a.Index.prototype.add=function(b,c){var d={},e=new a.SortedSet,f=b[this._ref],c=void 0===c||c;this._fields.forEach(function(a){var c=this.pipeline.run(this.tokenizerFn(b[a.name]));d[a.name]=c;for(var f=0;f<c.length;f++){var g=c[f];e.add(g),this.corpusTokens.add(g)}},this),this.documentStore.set(f,e);for(var g=0;g<e.length;g++){for(var h=e.elements[g],i=0,j=0;j<this._fields.length;j++){var k=this._fields[j],l=d[k.name],m=l.length;if(m){for(var n=0,o=0;m>o;o++)l[o]===h&&n++;i+=n/m*k.boost}}this.tokenStore.add(h,{ref:f,tf:i})}c&&this.eventEmitter.emit("add",b,this)},a.Index.prototype.remove=function(a,b){var c=a[this._ref],b=void 0===b||b;if(this.documentStore.has(c)){var d=this.documentStore.get(c);this.documentStore.remove(c),d.forEach(function(a){this.tokenStore.remove(a,c)},this),b&&this.eventEmitter.emit("remove",a,this)}},a.Index.prototype.update=function(a,b){var b=void 0===b||b;this.remove(a,!1),this.add(a,!1),b&&this.eventEmitter.emit("update",a,this)},a.Index.prototype.idf=function(a){var b="@"+a;if(Object.prototype.hasOwnProperty.call(this._idfCache,b))return this._idfCache[b];var c=this.tokenStore.count(a),d=1;return c>0&&(d=1+Math.log(this.documentStore.length/c)),this._idfCache[b]=d},a.Index.prototype.search=function(b){var c=this.pipeline.run(this.tokenizerFn(b)),d=new a.Vector,e=[],f=this._fields.reduce(function(a,b){return a+b.boost},0),g=c.some(function(a){return this.tokenStore.has(a)},this);if(!g)return[];c.forEach(function(b,c,g){var h=1/g.length*this._fields.length*f,i=this,j=this.tokenStore.expand(b).reduce(function(c,e){var f=i.corpusTokens.indexOf(e),g=i.idf(e),j=1,k=new a.SortedSet;if(e!==b){var l=Math.max(3,e.length-b.length);j=1/Math.log(l)}f>-1&&d.insert(f,h*g*j);for(var m=i.tokenStore.get(e),n=Object.keys(m),o=n.length,p=0;o>p;p++)k.add(m[n[p]].ref);return c.union(k)},new a.SortedSet);e.push(j)},this);var h=e.reduce(function(a,b){return a.intersect(b)});return h.map(function(a){return{ref:a,score:d.similarity(this.documentVector(a))}},this).sort(function(a,b){return b.score-a.score})},a.Index.prototype.documentVector=function(b){for(var c=this.documentStore.get(b),d=c.length,e=new a.Vector,f=0;d>f;f++){var g=c.elements[f],h=this.tokenStore.get(g)[b].tf,i=this.idf(g);e.insert(this.corpusTokens.indexOf(g),h*i)}return e},a.Index.prototype.toJSON=function(){return{version:a.version,fields:this._fields,ref:this._ref,tokenizer:this.tokenizerFn.label,documentStore:this.documentStore.toJSON(),tokenStore:this.tokenStore.toJSON(),corpusTokens:this.corpusTokens.toJSON(),pipeline:this.pipeline.toJSON()}},a.Index.prototype.use=function(a){var b=Array.prototype.slice.call(arguments,1);b.unshift(this),a.apply(this,b)},a.Store=function(){this.store={},this.length=0},a.Store.load=function(b){var c=new this;return c.length=b.length,c.store=Object.keys(b.store).reduce(function(c,d){return c[d]=a.SortedSet.load(b.store[d]),c},{}),c},a.Store.prototype.set=function(a,b){this.has(a)||this.length++,this.store[a]=b},a.Store.prototype.get=function(a){return this.store[a]},a.Store.prototype.has=function(a){return a in this.store},a.Store.prototype.remove=function(a){this.has(a)&&(delete this.store[a],this.length--)},a.Store.prototype.toJSON=function(){return{store:this.store,length:this.length}},a.stemmer=function(){var a={ational:"ate",tional:"tion",enci:"ence",anci:"ance",izer:"ize",bli:"ble",alli:"al",entli:"ent",eli:"e",ousli:"ous",ization:"ize",ation:"ate",ator:"ate",alism:"al",iveness:"ive",fulness:"ful",ousness:"ous",aliti:"al",iviti:"ive",biliti:"ble",logi:"log"},b={icate:"ic",ative:"",alize:"al",iciti:"ic",ical:"ic",ful:"",ness:""},c="[^aeiou]",d="[aeiouy]",e=c+"[^aeiouy]*",f=d+"[aeiou]*",g="^("+e+")?"+f+e,h="^("+e+")?"+f+e+"("+f+")?$",i="^("+e+")?"+f+e+f+e,j="^("+e+")?"+d,k=new RegExp(g),l=new RegExp(i),m=new RegExp(h),n=new RegExp(j),o=/^(.+?)(ss|i)es$/,p=/^(.+?)([^s])s$/,q=/^(.+?)eed$/,r=/^(.+?)(ed|ing)$/,s=/.$/,t=/(at|bl|iz)$/,u=new RegExp("([^aeiouylsz])\\1$"),v=new RegExp("^"+e+d+"[^aeiouwxy]$"),w=/^(.+?[^aeiou])y$/,x=/^(.+?)(ational|tional|enci|anci|izer|bli|alli|entli|eli|ousli|ization|ation|ator|alism|iveness|fulness|ousness|aliti|iviti|biliti|logi)$/,y=/^(.+?)(icate|ative|alize|iciti|ical|ful|ness)$/,z=/^(.+?)(al|ance|ence|er|ic|able|ible|ant|ement|ment|ent|ou|ism|ate|iti|ous|ive|ize)$/,A=/^(.+?)(s|t)(ion)$/,B=/^(.+?)e$/,C=/ll$/,D=new RegExp("^"+e+d+"[^aeiouwxy]$"),E=function(c){var d,e,f,g,h,i,j;if(c.length<3)return c;if(f=c.substr(0,1),"y"==f&&(c=f.toUpperCase()+c.substr(1)),g=o,h=p,g.test(c)?c=c.replace(g,"$1$2"):h.test(c)&&(c=c.replace(h,"$1$2")),g=q,h=r,g.test(c)){var E=g.exec(c);g=k,g.test(E[1])&&(g=s,c=c.replace(g,""))}else if(h.test(c)){var E=h.exec(c);d=E[1],h=n,h.test(d)&&(c=d,h=t,i=u,j=v,h.test(c)?c+="e":i.test(c)?(g=s,c=c.replace(g,"")):j.test(c)&&(c+="e"))}if(g=w,g.test(c)){var E=g.exec(c);d=E[1],c=d+"i"}if(g=x,g.test(c)){var E=g.exec(c);d=E[1],e=E[2],g=k,g.test(d)&&(c=d+a[e])}if(g=y,g.test(c)){var E=g.exec(c);d=E[1],e=E[2],g=k,g.test(d)&&(c=d+b[e])}if(g=z,h=A,g.test(c)){var E=g.exec(c);d=E[1],g=l,g.test(d)&&(c=d)}else if(h.test(c)){var E=h.exec(c);d=E[1]+E[2],h=l,h.test(d)&&(c=d)}if(g=B,g.test(c)){var E=g.exec(c);d=E[1],g=l,h=m,i=D,(g.test(d)||h.test(d)&&!i.test(d))&&(c=d)}return g=C,h=l,g.test(c)&&h.test(c)&&(g=s,c=c.replace(g,"")),"y"==f&&(c=f.toLowerCase()+c.substr(1)),c};return E}(),a.Pipeline.registerFunction(a.stemmer,"stemmer"),a.generateStopWordFilter=function(a){var b=a.reduce(function(a,b){return a[b]=b,a},{});return function(a){return a&&b[a]!==a?a:void 0}},a.stopWordFilter=a.generateStopWordFilter(["a","able","about","across","after","all","almost","also","am","among","an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","dear","did","do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","however","i","if","in","into","is","it","its","just","least","let","like","likely","may","me","might","most","must","my","neither","no","nor","not","of","off","often","on","only","or","other","our","own","rather","said","say","says","she","should","since","so","some","than","that","the","their","them","then","there","these","they","this","tis","to","too","twas","us","wants","was","we","were","what","when","where","which","while","who","whom","why","will","with","would","yet","you","your"]),a.Pipeline.registerFunction(a.stopWordFilter,"stopWordFilter"),a.trimmer=function(a){return a.replace(/^\W+/,"").replace(/\W+$/,"")},a.Pipeline.registerFunction(a.trimmer,"trimmer"),a.TokenStore=function(){this.root={docs:{}},this.length=0},a.TokenStore.load=function(a){var b=new this;return b.root=a.root,b.length=a.length,b},a.TokenStore.prototype.add=function(a,b,c){var c=c||this.root,d=a.charAt(0),e=a.slice(1);return d in c||(c[d]={docs:{}}),0===e.length?(c[d].docs[b.ref]=b,void(this.length+=1)):this.add(e,b,c[d])},a.TokenStore.prototype.has=function(a){if(!a)return!1;for(var b=this.root,c=0;c<a.length;c++){if(!b[a.charAt(c)])return!1;b=b[a.charAt(c)]}return!0},a.TokenStore.prototype.getNode=function(a){if(!a)return{};for(var b=this.root,c=0;c<a.length;c++){if(!b[a.charAt(c)])return{};b=b[a.charAt(c)]}return b},a.TokenStore.prototype.get=function(a,b){return this.getNode(a,b).docs||{}},a.TokenStore.prototype.count=function(a,b){return Object.keys(this.get(a,b)).length},a.TokenStore.prototype.remove=function(a,b){if(a){for(var c=this.root,d=0;d<a.length;d++){if(!(a.charAt(d)in c))return;c=c[a.charAt(d)]}delete c.docs[b]}},a.TokenStore.prototype.expand=function(a,b){var c=this.getNode(a),d=c.docs||{},b=b||[];return Object.keys(d).length&&b.push(a),Object.keys(c).forEach(function(c){"docs"!==c&&b.concat(this.expand(a+c,b))},this),b},a.TokenStore.prototype.toJSON=function(){return{root:this.root,length:this.length}},function(a,b){"function"==typeof define&&define.amd?define(b):"object"==typeof exports?module.exports=b():a.lunr=b()}(this,function(){return a})}(),a.fn.ghostHunter=function(b){var d=a.extend({},a.fn.ghostHunter.defaults,b);if(d.results)return c.init(this,d),c},a.fn.ghostHunter.defaults={resultsData:!1,onPageLoad:!1,onKeyUp:!1,result_template:"<a href='{{link}}'><p><h2>{{title}}</h2><h4>{{prettyPubDate}}</h4></p></a>",info_template:"<p>Number of posts found: {{amount}}</p>",displaySearchInfo:!0,zeroResultsInfo:!0,before:!1,onComplete:!1,includepages:!1,filterfields:!1};var b=function(a){var b=new Date(a),c=["January","February","March","April","May","June","July","August","September","October","November","December"];return b.getDate()+" "+c[b.getMonth()]+" "+b.getFullYear()},c={isInit:!1,init:function(a,b){var c=this;this.target=a,this.results=b.results,this.blogData={},this.result_template=b.result_template,this.info_template=b.info_template,this.zeroResultsInfo=b.zeroResultsInfo,this.displaySearchInfo=b.displaySearchInfo,this.before=b.before,this.onComplete=b.onComplete,this.includepages=b.includepages,this.filterfields=b.filterfields,this.index=lunr(function(){this.field("title",{boost:10}),this.field("description"),this.field("link"),this.field("markdown",{boost:5}),this.field("pubDate"),this.field("tag"),this.ref("id")}),b.onPageLoad?c.loadAPI():a.focus(function(){c.loadAPI()}),a.closest("form").submit(function(b){b.preventDefault(),c.find(a.val())}),b.onKeyUp&&a.keyup(function(){c.find(a.val())})},loadAPI:function(){if(this.isInit)return!1;var c=this.index,d=this.blogData;obj={limit:"all",include:"tags"},this.includepages&&(obj.filter="(page:true,page:false)"),a.get(ghost.url.api("posts",obj)).done(function(a){searchData=a.posts,searchData.forEach(function(a){var e=a.tags.map(function(a){return a.name});null==a.meta_description&&(a.meta_description="");var f=e.join(", ");f.length<1&&(f="undefined");var g={id:String(a.id),title:String(a.title),description:String(a.meta_description),markdown:String(a.markdown),pubDate:String(a.created_at),tag:f,link:String(a.url)};g.prettyPubDate=b(g.pubDate);var h=b(g.pubDate);c.add(g),d[a.id]={title:a.title,description:a.meta_description,pubDate:h,link:a.url}})}),this.isInit=!0},find:function(b){var c=this.index.search(b),d=a(this.results),e=[];d.empty(),this.before&&this.before(),(this.zeroResultsInfo||c.length>0)&&this.displaySearchInfo&&d.append(this.format(this.info_template,{amount:c.length}));for(var f=0;f<c.length;f++){var g=c[f].ref,h=this.blogData[g];d.append(this.format(this.result_template,h)),e.push(h)}this.onComplete&&this.onComplete(e)},clear:function(){a(this.results).empty(),this.target.val("")},format:function(a,b){return a.replace(/{{([^{}]*)}}/g,function(a,c){var d=b[c];return"string"==typeof d||"number"==typeof d?d:a})}}}(jQuery);