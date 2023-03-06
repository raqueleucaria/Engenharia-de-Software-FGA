library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity clockDiv is
    Port ( clk : in STD_LOGIC;
           clk_div : inout STD_LOGIC);
end clockDiv;

architecture Behavioral of clockDiv is

    signal counter : integer range 1 to 100_000_000 := 1;

begin

divisor_clk : process(clk)
    
    begin
    
        if rising_edge(clk) then
            
            if counter = 100_000_000 then
                
                counter  <= 1;
                clk_div <= not clk_div;
            else 
            
                counter <= counter + 1;
                    
            end if;          
        end if;
    end process;

end Behavioral;
