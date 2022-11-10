# 487sp19_projectile-inferno

Bullet hell game project by team 'DROP TABLE teams' for CS-487 at WSU. Bullet hell game that uses the component system, entity architecture, and uses libgdx library in Java. Created scripted levels and scripted behavours for the enemy. various enemies types The player is able to collect power ups that have various effect on the player. We even implemented cheat functionality for testing. we implemented event listeners for collision detection. The library we used for the interface of the entity, component, sytem architecture (libECS) is designed by one of our memebrs Ian Mclerran.   

# entity, component, system architecture
The component, entity, system architecture is important for this project with the enity is an ID, the component is basically a struct of data, and the system is the logic that used on the component. For Entity and component we have managers, that is in charge of keeping track of and creating or removing an new entity. A component manager which adds or remove components. (For more information it is provided in the readme in the libECS folder.) 
