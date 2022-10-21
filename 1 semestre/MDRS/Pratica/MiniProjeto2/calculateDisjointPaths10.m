function [sP1 sP2 ]= calculateDisjointPaths10(L,T)
    nFlows= size(T,1);
    nSP= zeros(1,nFlows);

    for i=1:nFlows
        [shortestPath, totalCost] = kShortestPath(L,T(i,1),T(i,2),10); %queremos os 10 percursos com custo minimo 
    
        NewAuxL=L;
        for k= 1:10
            tempshortestPath = cell2mat(shortestPath(k));
            
            for j=2:length(tempshortestPath)
                NewAuxL(tempshortestPath(j),tempshortestPath(j-1))= inf;
                NewAuxL(tempshortestPath(j-1),tempshortestPath(j))= inf;
            end
        end
    end


    for i=1:nFlows
        [shortestPath, totalCost] = kShortestPath(NewAuxL,T(i,1),T(i,2),1);
        sP1{i}= shortestPath;
        path1= shortestPath{1};
        Laux= NewAuxL;
        for j=2:length(path1)
            Laux(path1(j),path1(j-1))= inf;
            Laux(path1(j-1),path1(j))= inf;
        end
        [shortestPath, totalCost] = kShortestPath(Laux,T(i,1),T(i,2),1);
        if length(shortestPath)>0
            sP2{i}= shortestPath;
            
        else
            sP2{i}= {[]};
            s2(i)= 0;
        end
    end
end