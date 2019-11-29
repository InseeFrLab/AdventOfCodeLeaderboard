<div class="panel-group" id="accordion">
    <#list qanda.categories as category>
        <div class="faqHeader">${category.category}</div>
        <#list category.questions as question>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">${question.question}</a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                    ${question.answer}
                </div>
            </div>
        </div>
        </#list>
    </#list>
</div>
