
select avg(closing_quotation) from stock where stock_Id=0025002;


select DATE_FORMAT(time,'%Y') years,avg(closing_quotation),(select avg(closing_quotation) from stock where stock_Id=0025002) from stock where stock_Id=0025002 group by years;


select DATE_FORMAT(time,'%M') years,avg(closing_quotation) from stock where stock_Id=0025002 group by years;