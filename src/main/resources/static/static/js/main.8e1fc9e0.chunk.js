(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{240:function(e,a,t){e.exports=t(425)},245:function(e,a,t){},246:function(e,a,t){},425:function(e,a,t){"use strict";t.r(a);var n=t(0),l=t.n(n),i=t(23),o=t.n(i),r=(t(245),t(204)),c=t(205),d=t(228),m=t(206),s=t(229),u=t(20),f=(t(246),t(445)),C=t(443),h=t(446),E=t(102),g=t(440),p=t(100),y=t.n(p),v=t(60),D=(t(265),function(){return l.a.createElement("div",{style:{textAlign:"center"}},"Bilgi Giri\u015f Uygulamas\u0131na Ho\u015f Geldiniz Welcome to info entrance app v1.0.7")}),O=t(441),w=t(437),k=t(438),b=t(138),S=function(e){var a=e.modelOpened,t=e.onDeleteClick,n=e.onSaveClick,i=e.onRenewClick;return l.a.createElement("div",null,l.a.createElement(O.a,null,l.a.createElement(O.a.Group,{style:{display:"none"}},l.a.createElement(O.a.Field,null,l.a.createElement(w.a,{placeholder:"id",id:"id",value:e.formData.id}))),l.a.createElement(O.a.Group,null,l.a.createElement(O.a.Field,null,l.a.createElement(w.a,{placeholder:"Ad Bilgisi giriniz",id:"ad",value:e.formData.ad,onChange:e.onFormDataChanged}))),l.a.createElement(O.a.Group,null,l.a.createElement(O.a.Field,null,l.a.createElement(w.a,{placeholder:"Soyad Bilgisi giriniz",id:"soyad",value:e.formData.soyad,onChange:e.onFormDataChanged}))),l.a.createElement(O.a.Group,null,l.a.createElement(O.a.Field,null,l.a.createElement(k.a,{placeholder:"Adres Bilgisi giriniz",id:"adres",value:e.formData.adres,onChange:e.onFormDataChanged}))),l.a.createElement(O.a.Group,null,l.a.createElement(O.a.Field,null,l.a.createElement(w.a,{placeholder:"Do\u011fum Yeri",id:"dogumYeri",value:e.formData.dogumYeri,onChange:e.onFormDataChanged})))),l.a.createElement(b.a,{floated:"right",primary:!0,onClick:n},"Kaydet"),a&&l.a.createElement(b.a,{color:"red",floated:"right",onClick:t},"Sil"),!a&&l.a.createElement(b.a,{floated:"right",onClick:i},"Yenile"))},F=t(444),I=t(439),j=t(442),G=t(50),R={textAlign:"center"},Y=function(e){var a=e.tableData,t=e.onIconClick,n=e.loading;return l.a.createElement("div",null,l.a.createElement(F.a,{active:n},l.a.createElement(I.a,null,"Y\xfckleniyor")),l.a.createElement(j.a,{celled:!0},l.a.createElement(j.a.Header,null,l.a.createElement(j.a.Row,null,l.a.createElement(j.a.HeaderCell,{width:5,style:R},"Ad"),l.a.createElement(j.a.HeaderCell,{width:5,style:R},"Soyad"),l.a.createElement(j.a.HeaderCell,{width:10,style:R},"Adres"),l.a.createElement(j.a.HeaderCell,{width:10,style:R},"Do\u011fum Yeri"),l.a.createElement(j.a.HeaderCell,{width:2,style:R},"\u0130\u015flem"))),l.a.createElement(j.a.Body,null,a.map(function(e){return l.a.createElement(j.a.Row,{celled:!0,key:e.id},l.a.createElement(j.a.Cell,{style:R},e.ad),l.a.createElement(j.a.Cell,{style:R},e.soyad),l.a.createElement(j.a.Cell,{style:R},e.adres),l.a.createElement(j.a.Cell,{style:R},e.dogumYeri),l.a.createElement(j.a.Cell,{style:R},l.a.createElement(G.a,{name:"pencil",id:e.id,onClick:t})))}))))},H=function(e){function a(){var e;return Object(r.a)(this,a),(e=Object(d.a)(this,Object(m.a)(a).call(this))).state={modelOpened:!1,activeItem:"Giri\u015f",formData:{id:null,ad:"",soyad:"",adres:""},windowFormData:{id:null,ad:"",soyad:"",adres:""},tableData:[],loading:!1,confirmOpened:!1},e.onFormDataChanged=function(a,t){if(Object(u.a)(Object(u.a)(e)).state.modelOpened){var n=t.id,l=t.value,i=e.state.windowFormData;i[n]=l,e.setState(i)}else{var o=t.id,r=t.value,c=e.state.formData;c[o]=r,e.setState(c)}},e.onDeleteClick=function(){e.setConfirmWindowOpened(!0)},e.onRenewClick=function(){e.setState({formData:{id:null,ad:"",soyad:"",adres:"",dogumYeri:""}})},e.onSaveClick=function(){var a=Object(u.a)(Object(u.a)(e)).state.modelOpened,t=a?e.state.windowFormData:e.state.formData,n=Object(u.a)(Object(u.a)(e));y.a.post("/formData",t).then(function(e){var t=e.data,l=t.success,i=t.message,o=t.dto;!0===l?(n.notifySuccess(i),a?n.setState({windowFormData:o}):n.setState({formData:o})):n.notifyFailure(i)}).catch(function(e){console.log(e),n.notifyFailure("Hata Durum olu\u015fmu\u015ftur. L\xfctfen Sistem Y\xf6neticiniz ile g\xf6r\xfc\u015f\xfcn\xfcz")})},e.handleItemClick=function(a,t){var n=t.name;"Listeleme"===n&&e.sendListRequest(),e.setState({activeItem:n})},e.sendListRequest=function(){var a=Object(u.a)(Object(u.a)(e));e.setState({loading:!0}),y.a.get("/formData").then(function(e){var t=e.data,n=t.success,l=t.message,i=t.list;!0===n?(a.notifySuccess(l),a.setState({tableData:i,loading:!1})):(a.notifyFailure(l),a.setState({loading:!1}))}).catch(function(e){console.log(e),a.setState({tableData:[{id:1,ad:"adi",soyad:"soyad",adres:"adres"},{id:2,ad:"adi",soyad:"soyad",adres:"adres"}],loading:!1})})},e.notifySuccess=function(e){v.b.success(e,{position:v.b.POSITION.TOP_RIGHT,autoClose:5e3})},e.notifyFailure=function(e){v.b.error(e,{position:v.b.POSITION.TOP_RIGHT,autoClose:5e3})},e.setModelOpened=function(a){e.setState({modelOpened:a})},e.onIconClick=function(a,t){var n=t.id,l=e.state.tableData.filter(function(e){return e.id===n});if(l.length>0){var i=l[0];e.setState({modelOpened:!0,windowFormData:i})}else e.notifyFailure(n+" numaral\u0131 kay\u0131t liste i\xe7inde bulunam\u0131\u015ft\u0131r")},e.onConfirmCancel=function(){e.setConfirmWindowOpened(!1)},e.onConfirmed=function(){if(Object(u.a)(Object(u.a)(e)).state.modelOpened){var a=e.state.windowFormData,t=Object(u.a)(Object(u.a)(e));y.a.delete("/formData",{data:a}).then(function(e){var a=e.data,n=a.success,l=a.message;!0===n?(t.notifySuccess(l),t.setModelOpened(!1),t.sendListRequest(),t.setConfirmWindowOpened(!1)):t.notifyFailure(l)}).catch(function(e){console.log(e),t.notifyFailure("HataonRenewClick Durum olu\u015fmu\u015ftur. L\xfctfen Sistem Y\xf6neticiniz ile g\xf6r\xfc\u015f\xfcn\xfcz")})}},e.onFormDataChanged=e.onFormDataChanged.bind(Object(u.a)(Object(u.a)(e))),document.title="Task Page",e}return Object(s.a)(a,e),Object(c.a)(a,[{key:"setConfirmWindowOpened",value:function(e){this.setState({confirmOpened:e})}},{key:"render",value:function(){var e=this,a=this.state,t=a.activeItem,n=a.formData,i=a.tableData,o=a.modelOpened,r=a.windowFormData,c=a.loading,d=a.confirmOpened,m="Giri\u015f"===t,s="Yeni Kay\u0131t"===t,u="Listeleme"===t;return l.a.createElement("div",null,l.a.createElement(v.a,null),l.a.createElement(f.a,null,l.a.createElement(f.a.Column,{width:3},l.a.createElement(C.a,{fluid:!0,vertical:!0,tabular:!0},l.a.createElement(C.a.Item,{name:"Giri\u015f",active:m,onClick:this.handleItemClick}),l.a.createElement(C.a.Item,{name:"Yeni Kay\u0131t",active:s,onClick:this.handleItemClick}),l.a.createElement(C.a.Item,{name:"Listeleme",active:u,onClick:this.handleItemClick}))),l.a.createElement(f.a.Column,{stretched:!0,width:12},l.a.createElement(h.a,null,m&&l.a.createElement(D,null),s&&l.a.createElement(S,{formData:n,onFormDataChanged:this.onFormDataChanged,onSaveClick:this.onSaveClick,modelOpened:o,onRenewClick:this.onRenewClick}),u&&l.a.createElement(Y,{tableData:i,onIconClick:this.onIconClick,loading:c})))),l.a.createElement(E.a,{onClose:function(){return e.setModelOpened(!1)},onOpen:function(){return e.setModelOpened(!0)},open:o},l.a.createElement(E.a.Content,null,l.a.createElement(S,{formData:r,onFormDataChanged:this.onFormDataChanged,onSaveClick:this.onSaveClick,onDeleteClick:this.onDeleteClick,modelOpened:o}))),l.a.createElement(g.a,{open:d,content:"Silme i\u015flemi ger\xe7ekle\u015ftirilecektir. Onayl\u0131yor musunuz?",cancelButton:"\u0130ptal Et",confirmButton:"Onayla",onCancel:this.onConfirmCancel,onConfirm:this.onConfirmed}))}}]),a}(n.Component);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var z=document.createElement("link");z.rel="stylesheet",z.href="https://cdn.jsdelivr.net/npm/semantic-ui/dist/semantic.min.css",document.head.appendChild(z),o.a.render(l.a.createElement(H,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})}},[[240,1,2]]]);
//# sourceMappingURL=main.8e1fc9e0.chunk.js.map